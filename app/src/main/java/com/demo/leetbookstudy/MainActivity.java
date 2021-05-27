package com.demo.leetbookstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.leetbookstudy.codec.Codec;
import com.demo.leetbookstudy.permutation.Permutation;
import com.demo.leetbookstudy.substructure.TreeNode;

import java.net.HttpURLConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public static void main(String[] args) {
        Permutation permutation = new Permutation();
       String[] strings = permutation.permutation("abcd");
       System.out.println("size: "+strings.length);
        System.out.print("[");
        for (String str:strings) {
            System.out.print("\""+str+"\",");
        }
        System.out.print("]");
    }
}