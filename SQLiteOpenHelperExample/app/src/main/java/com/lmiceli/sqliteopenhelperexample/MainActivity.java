package com.lmiceli.sqliteopenhelperexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PostsDatabaseHelper dbHelper = PostsDatabaseHelper.getInstance(this);

        User user = new User();
        user.userName = "Pedro";
        user.profilePictureUrl = "some-url.com";
        dbHelper.addOrUpdateUser(user);

        Post post = new Post();
        post.user = user;
        post.text = "This is my philosophy";
        dbHelper.addPost(post);

        List<Post> allPosts = dbHelper.getAllPosts();

        if (allPosts.size() > 0){
            TextView postView = (TextView) findViewById(R.id.post);
            postView.setText(allPosts.get(0).text);
            TextView authorView = (TextView) findViewById(R.id.author);
            authorView.setText("by " + allPosts.get(0).user.userName);
        }

        //TODO when detach?

    }
}
