package ie.ul.assignment_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class Reading extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("messages")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        String messages = "";
                        if(task.isSuccessful()) {
                            int i = 0;
                            for(QueryDocumentSnapshot document:task.getResult()) {
                                String title = document.get("title").toString();
                                String author = document.get("author").toString();
                                String content = document.get("content").toString();
                                messages = messages + title + "\t" + author + "\n" + content + "\n\n";
                                i++;
                                if(i >= 5)
                                    break;
                            }
                        }
                        TextView textView = findViewById(R.id.output);
                        textView.setText(messages);
                    }
                });

        // roll
        TextView textView = (TextView)findViewById(R.id.output);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
    }

    public void onClickPost(View view) {
        Intent intent = new Intent(Reading.this, Post.class);
        startActivity(intent);
    }
}
