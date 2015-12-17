package the.nice.button;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class singleNiceActivity extends Activity {

	private Button NiceButton;
	private MediaPlayer mp;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_nice);
        initControls();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

	/*************************************************
	 * I HAVE NO IDEA WHAT THIS DOES OR WHY I PUT IT HERE
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
        case R.id.old_about:
            old_about();
            return true;
        case R.id.separate:
        	separate();
        	return true;
        case R.id.old_preferences:
        	old_preferences();
        	return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
    *******************************************************/

    // initialize
    private void initControls()
    {
    	NiceButton = (Button) findViewById(R.id.NiceButton);
    	
    	NiceButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Context context = getApplicationContext();
                CharSequence text;
                int duration = Toast.LENGTH_SHORT;

                try {
                    int i = (int) (Math.random() * 3) + 1;
                    switch (i) {
                        case 2:
                            mp = MediaPlayer.create(context, R.raw.nice2);
                            break;
                        case 3:
                            mp = MediaPlayer.create(context, R.raw.nice3);
                            break;
                        default:
                            mp = MediaPlayer.create(context, R.raw.nice1);
                    }
                    mp.start();

                    // waiting until playback ends and reset
                    mp.setOnCompletionListener(new OnCompletionListener() {
                                                   @Override
                                                   public void onCompletion(MediaPlayer mp) {
                                                       resetMP();
                                                   }
                                               }
                    );

                    // display success toast
                    text = "Nice!";
                    //Toast.makeText(context, text, duration).show();
                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    // display failure toast
                    text = "Broke!\n" + e;
                    Toast.makeText(context, text, duration).show();
                } catch (IllegalStateException e) {
                    // TODO Auto-generated catch block
                    // display failure toast
                    text = "Broke!\n" + e;
                    Toast.makeText(context, text, duration).show();
                }
            }
        });
    }
    
    //reset media player
    private void resetMP()
    {
    	mp.reset();
    }
    
    /********************************************************************
	 * LITERALLY BULLSHIT. WTF WAS I THINKING WITH THIS SHIT
    private void old_about()
    {
    	Intent i = new Intent(singleNiceActivity.this, OLD_AboutScreen.class);
    	startActivity(i);
    }
    
    
    private void old_preferences()
    {
    	Intent i = new Intent(singleNiceActivity.this, OLD_PreferencesScreen.class);
    	startActivity(i);
    }
    
    private void separate()
    {
    	Intent i = new Intent(singleNiceActivity.this, OLD_SeparateButtons.class);
    	startActivity(i);
    }
    **********************************************************************/
    
}