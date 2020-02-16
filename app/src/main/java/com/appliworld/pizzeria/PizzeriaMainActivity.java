package com.appliworld.pizzeria;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.AsyncTask;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Fragment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.prefs.Preferences;


import layout.frgMenuIngredient;
import layout.frgMenuPizza;

import static android.R.id.content;

//log.d("","");

public class PizzeriaMainActivity extends AppCompatActivity{
    private String numT;
    private TextView txtNum;
    public Fragment menuPizza;
    public Fragment menuIngredient;
    public String order="";
    //Erreur??
    //PreferenceFragment prefFrag=new Pres();

    //private TextView etatCommande;//pour voir l'etat du commande
    private class Cuisine extends AsyncTask<String,String,Void>
    {
        protected void preExecute()
        {
            System.out.println("Commencer a preparer votre demande.");
        }
        protected Void doInBackground(String... pizza)
        {
            try
            {
                //se connecter au serveur
                Socket socket=new Socket("chadok.info",9874);
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                String msgW=pizza[0];
                //writer.write(pizza[0]);
                //writer.write(pizza[1]);
                writer.write(msgW);
                writer.flush();
                // writer.close();

                String msg="";
                //"La table x a commande : xxxxxxx"
                while(msg.equals(""))
                {
                    Log.d("Cuisine", "Attente de feedback du serveur");
                    if (reader.ready())
                        msg = reader.readLine();
                    Thread.sleep(1000);
                }
                publishProgress(msg);
                msg="";
                ///a changer!!!
                //"La commande de la table x est prete : xxxxxxxx"
                while(msg.equals(""))
                {
                    if (reader.ready())
                        msg = reader.readLine();
                    Thread.sleep(1000);
                }
                publishProgress(msg);

            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            return null;
        }
        protected void onProgressUpdate(String... msg)
        {
            //Snackbar pas reussi --> utiliser Toast
            /*Snackbar snk=new Snackbar.make(R.id.coordinatorLayout,msg, Snackbar.LENGTH_LONG).setAction("OK", new View.OnClickListener()
                                {
                                    @Override
                                    public void onClick(View v){}
                                } ).show();*/

            //Afficher un toast pour suivre l'etat du commande
            Toast.makeText(getApplicationContext(),msg[0],Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizzeria_main);
        System.out.println("onCreate PizzeriaMainActivity");


        txtNum=(TextView) findViewById(R.id.txtNumTable);

        //recuperer le numero de la table
        Intent intent = getIntent();
        numT = intent.getStringExtra("num");

        //pas possible d'etre negatif
        /*while(Integer.parseInt(numT)<0)
        {
            Toast.makeText(this,"Numero invalid!",Toast.LENGTH_SHORT).show();
        }*/

        if(Integer.parseInt(numT)<10)
            numT="0"+Integer.parseInt(numT);
        //afficher le numero
        String content="Commande de la table n."+numT;
        txtNum.setText(content);
        order+=numT;

        //creer des fragments
        if(menuPizza==null)
            menuPizza = new frgMenuPizza();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.frgMenu,menuPizza);
        transaction.commit();

        if(menuIngredient==null)
            menuIngredient=new frgMenuIngredient();

        //pour le background
        View v = findViewById(R.id.fond);
        //definir la transparence
        v.getBackground().setAlpha(70);
    }

    public void sendOrder()
    {
        new Cuisine().execute(this.order,null,null);
    }

    public void applyPref() {
        // - récupérer les valeurs choisies par l'utilisateur
        /*SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        boolean redTitle = sharedPref.getBoolean(String.valueOf(getResources().getText(R.string.RED_BUTTON)), false);

        // - les appliquer
        title.setTextColor(redTitle ? Color.RED : Color.BLACK);*/
        /*if (this.menuPizza==null)
            this.menuPizza=new frgMenuPizza();
        this.menuPizza.btnRouge();
        if(this.menuIngredient==null)
            this.menuIngredient=new frgMenuIngredient();
        this.menuIngredient.btnRouge();*/
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        //pas completer parce que l'indice de Pres ne peut pas etre cree!
        /*if (id == R.id.preferences)
        {

        }
        else
        {

        }*/
        return super.onOptionsItemSelected(item);
    }



    protected void onStart()
    {
        super.onStart();
        System.out.println("onStart PizzeriaMainActivity");
    }
    protected void onRestart()
    {
        super.onRestart();
        System.out.println("onRestart PizzeriaMainActivity");
    }
    protected void onResume()
    {
        super.onResume();
        System.out.println("onResume PizzeriaMainActivity");
    }
    protected void onPause()
    {
        super.onPause();
        System.out.println("onPause PizzeriaMainActivity");
    }
    protected void onStop()
    {
        super.onStop();
        System.out.println("onStop PizzeriaMainActivity");
    }
    protected void onDestroy()
    {
        super.onDestroy();
        System.out.println("onDestroy PizzeriaMainActivity");
    }
}
