package tesco.pm.tescostore;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        TextView email = (TextView) findViewById(R.id.email);
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Uri uri = Uri.parse("mailto:modipawan8126@gmail.com" )
                        .buildUpon()
                        .appendQueryParameter("subject", "")
                        .appendQueryParameter("body", "")
                        .build();*/
                Uri data = Uri.parse("mailto:modipawan8126@gmail.com?subject=&body=");
                Intent intent = new Intent(Intent.ACTION_SENDTO, data);

                intent.putExtra(Intent.EXTRA_EMAIL, "modipawan8126@gmail.com");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Query");
                intent.putExtra(Intent.EXTRA_TEXT, "");
                startActivity(Intent.createChooser(intent, "Send Email"));
                /*Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL, "modipawan8126@gmail.com");
                intent.putExtra(Intent.EXTRA_SUBJECT, "");
                intent.putExtra(Intent.EXTRA_TEXT, "");
                Intent mailer = Intent.createChooser(intent, "send email..");
                startActivity(mailer);*/
            }
        });
    }
}
