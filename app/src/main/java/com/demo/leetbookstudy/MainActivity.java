package com.demo.leetbookstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.admin.DevicePolicyManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.leetbookstudy.buildtree.BuildTree;
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
        int[] preorder = { 1, 2, 4, 7, 3, 5, 6, 8 };
        int[] inorder = { 4, 7, 2, 1, 5, 3, 8, 6 };

        new BuildTree().buildTree(preorder,inorder);
    }
}