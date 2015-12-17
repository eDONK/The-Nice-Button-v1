package the.nice.button;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class OLD_PreferencesScreen extends Activity {
	
	private Button get_something;
	
	@Override
	protected void onCreate(Bundle yay)
	{
		super.onCreate(yay);
		setContentView(R.layout.old_preferences);

		get_something = (Button)findViewById(R.id.get_something);
		get_something.setOnClickListener(mGetSomethingListener);
	}
	
	private OnClickListener mGetSomethingListener = new OnClickListener() {
		public void onClick(View v)
		{
			Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("audio/*");
            startActivity(Intent.createChooser(intent, "Select something"));
		}
	};
}