package ie.ul.assignment_2;

import java.util.Date;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class setData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_data);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String author = intent.getStringExtra("author");
        String content = intent.getStringExtra("content");
        Date date = new Date();
        String time = (9999-date.getTime()/100000000000.0)+"";

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        CollectionReference messages = db.collection("messages");

        Map<String, Object> message = new HashMap<>();
        message.put("title", title);
        message.put("author", author);
        message.put("content", content);
        message.put("time", time);
        messages.document(time).set(message);

        Intent intentt = new Intent(setData.this, Reading.class);
        startActivity(intentt);
    }
}
