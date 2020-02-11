package ie.ul.assignment_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Post extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
    }

    public void onClickPPost(View view) {
        Intent intent = new Intent(Post.this, setData.class);
        EditText editText1 = (EditText)findViewById(R.id.title);
        EditText editText2 = (EditText)findViewById(R.id.author);
        EditText editText3 = (EditText)findViewById(R.id.content);
        String title = editText1.getText().toString();
        String author = editText2.getText().toString();
        String content = editText3.getText().toString();
        intent.putExtra("title", title);
        intent.putExtra("author", author);
        intent.putExtra("content", content);
        startActivity(intent);
    }
}
