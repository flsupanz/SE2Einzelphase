package com.example.einfhrungsbeispiel;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends AsyncTask<String,Void,String> {



        Socket socket;
        BufferedReader bufferedReader;
        PrintWriter pw;
        String response;

        @Override
        protected String doInBackground(String... voids) {

        try {
             socket = new Socket("se2-isys.aau.at", 53212);
             pw = new PrintWriter((socket.getOutputStream()), true);
             pw.write(voids[0]);
             bufferedReader = new BufferedReader((new InputStreamReader(socket.getInputStream())));
             response  = bufferedReader.readLine();

             onPostExecute(response);



        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}

