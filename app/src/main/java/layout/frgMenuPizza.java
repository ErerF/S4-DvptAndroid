package layout;


import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.appliworld.pizzeria.PizzeriaMainActivity;
import com.appliworld.pizzeria.R;

import static com.appliworld.pizzeria.R.id.btn4Fromages;
import static com.appliworld.pizzeria.R.id.btnHawai;
import static com.appliworld.pizzeria.R.id.btnMontagnarde;
import static com.appliworld.pizzeria.R.id.btnNapolitaine;
import static com.appliworld.pizzeria.R.id.btnPannaCotta;
import static com.appliworld.pizzeria.R.id.btnPersonnaliser;
import static com.appliworld.pizzeria.R.id.btnRaclette;
import static com.appliworld.pizzeria.R.id.btnReinit;
import static com.appliworld.pizzeria.R.id.btnRoyale;
import static com.appliworld.pizzeria.R.id.btnTiramisu;

/**
 * A simple {@link Fragment} subclass.
 */
public class frgMenuPizza extends Fragment implements View.OnClickListener{
    private Button btnNapo;
    private Button btnRoy;
    private Button btn4F;
    private Button btnMont;
    private Button btnRac;
    private Button btnHaw;
    private Button btnPC;
    private Button btnTrms;
    private Button btnPerso;
    private Button btnReinitialiser;

    private PizzeriaMainActivity context;

    public final static String NBNAPO = "NBNAPO";
    public final static String NBROY = "NBROY";
    public final static String NB4F = "NB4F";
    public final static String NBMONT = "NBMONT";
    public final static String NBRAC= "NBRAC";
    public final static String NBHAW = "NBHAW";
    public final static String NBPC = "NBPC";
    public final static String NBTRMS = "NBTRMS";

    private int nbNapo;
    private int nbRoy;
    private int nb4F;
    private int nbMont;
    private int nbRac;
    private int nbHaw;
    private int nbPC;
    private int nbTrms;

    public frgMenuPizza() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_frg_menu_pizza, container, false);

        //recuperer les boutons
        btnNapo = (Button) v.findViewById(btnNapolitaine);
        btnRoy = (Button) v.findViewById(btnRoyale);
        btn4F = (Button) v.findViewById(btn4Fromages);
        btnMont = (Button) v.findViewById(btnMontagnarde);
        btnRac = (Button) v.findViewById(btnRaclette);
        btnHaw = (Button) v.findViewById(btnHawai);
        btnPC = (Button) v.findViewById(btnPannaCotta);
        btnTrms = (Button) v.findViewById(btnTiramisu);
        btnPerso=(Button)v.findViewById(btnPersonnaliser);
        btnReinitialiser=(Button)v.findViewById(btnReinit);

        //ajouter des ecouteurs aux boutons
        btnNapo.setOnClickListener(this);
        btnRoy.setOnClickListener(this);
        btn4F.setOnClickListener(this);
        btnMont.setOnClickListener(this);
        btnRac.setOnClickListener(this);
        btnHaw.setOnClickListener(this);
        btnPC.setOnClickListener(this);
        btnTrms.setOnClickListener(this);
        btnPerso.setOnClickListener(this);
        btnReinitialiser.setOnClickListener(this);

        //initialiser les nombres
        nbNapo=nbRoy=nb4F=nbMont=nbRac=nbHaw=nbPC=nbTrms=0;

        //verifier si il y des pizzas deja demandes
        if (savedInstanceState != null)
        {
            nbNapo = savedInstanceState.getInt(NBNAPO);
            nbRoy = savedInstanceState.getInt(NBROY);
            nb4F  = savedInstanceState.getInt(NB4F );
            nbMont = savedInstanceState.getInt(NBMONT);
            nbRac= savedInstanceState.getInt(NBRAC);
            nbHaw = savedInstanceState.getInt(NBHAW);
            nbPC = savedInstanceState.getInt(NBPC);
            nbTrms = savedInstanceState.getInt(NBTRMS);

            if(nbNapo!=0)
                btnNapo.setText("NAPOLITAINE:" + nbNapo);
            if(nbRoy!=0)
                btnRoy.setText("ROYALE:" + nbRoy);
            if(nb4F!=0)
                btn4F .setText("QUATRE FROMAGES:" + nb4F );
            if(nbMont!=0)
                btnMont.setText("MONTAGNARDE:" + nbMont);
            if(nbRac!=0)
                btnRac.setText("RACLETTE:" + nbRac);
            if(nbHaw!=0)
                btnHaw.setText("HAWAI:" + nbHaw);
            if(nbPC!=0)
                btnPC.setText("PANNA COTTA:" + nbPC);
            if(nbTrms!=0)
                btnTrms.setText("TIRAMISU:" + nbTrms);
        }

        context= (PizzeriaMainActivity) this.getActivity();

        return v;
    }

    public void onClick(View v) {
        if(v.getId()==btnNapolitaine)
        {
            onClickNapo();
        }
        else if(v.getId()==btnRoyale)
        {
            onClickRoyale();
        }
        else if(v.getId()==btn4Fromages)
        {
            onClick4F();
        }
        else if(v.getId()==btnMontagnarde)
        {
            onClickMont();
        }
        else if(v.getId()==btnRaclette)
        {
            onClickRac();
        }
        else if(v.getId()==btnHawai)
        {
            onClickHaw();
        }
        else if(v.getId()==btnPannaCotta)
        {
            onClickPC();
        }
        else if(v.getId()==btnTiramisu)
        {
            onClickTrms();
        }
        else if(v.getId()==btnPersonnaliser)
        {
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.frgMenu,context.menuIngredient);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if(v.getId()==btnReinit)
        {
            onClickReinit();
        }
    }

    public void onClickNapo()
    {
        nbNapo++;
        btnNapo.setText("NAPOLITAINE:" + nbNapo);
        context.order+="napolitaine";
        btnNapo.setBackgroundColor((Color.parseColor("#FFFF00")));
    }
    public void onClickRoyale()
    {
        nbRoy++;
        btnRoy.setText("ROYALE:" + nbRoy);
        context.order+="royale";
        btnRoy.setBackgroundColor((Color.parseColor("#FFFF00")));
    }
    public void onClick4F()
    {
        nb4F++;
        btn4F.setText("QUATRE FROMAGES:" + nb4F);
        context.order+="quatrefromages";
        btn4F.setBackgroundColor((Color.parseColor("#FFFF00")));
    }
    public void onClickMont() {
        nbMont++;
        btnMont.setText("MONTAGNARDE:" + nbMont);
        context.order += "montagnarde";
        btnMont.setBackgroundColor((Color.parseColor("#FFFF00")));
    }
    public void onClickRac()
    {
        nbRac++;
        btnRac.setText("RACLETTE:" + nbRac);
        context.order+="raclette";
        btnRac.setBackgroundColor((Color.parseColor("#FFFF00")));
    }
    public void onClickHaw()
    {
        nbHaw++;
        btnHaw.setText("HAWAI:" + nbHaw);
        context.order+="hawai";
        btnHaw.setBackgroundColor((Color.parseColor("#FFFF00")));
    }
    public void onClickPC()
    {
        nbPC++;
        btnPC.setText("PANNA COTTA:" + nbPC);
        context.order+="pannacotta";
        btnPC.setBackgroundColor((Color.parseColor("#FFFF00")));
    }
    public void onClickTrms()
    {
        nbTrms++;
        btnTrms.setText("TIRAMISU:" + nbTrms);
        context.order+="tiramisu";
        btnTrms.setBackgroundColor((Color.parseColor("#FFFF00")));
    }
    public void onClickReinit()
    {
        nbNapo=nbRoy=nb4F=nbMont=nbRac=nbHaw=nbPC=nbTrms=0;
        btnNapo.setText("NAPOLITAINE");
        btnRoy.setText("ROYALE" );
        btn4F.setText("QUATRE FROMAGES" );
        btnMont.setText("MONTAGNARDE" );
        btnRac.setText("RACLETTE" );
        btnHaw.setText("HAWAI" );
        btnPC.setText("PANNA COTTA");
        btnTrms.setText("TIRAMISU");
    }

    public void btnRouge()
    {
        btnNapo.setBackgroundColor((Color.parseColor("#FF4500")));
        btnRoy.setBackgroundColor((Color.parseColor("#FF4500")));
        btn4F.setBackgroundColor((Color.parseColor("#FF4500")));
        btnMont.setBackgroundColor((Color.parseColor("#FF4500")));
        btnRac.setBackgroundColor((Color.parseColor("#FF4500")));
        btnHaw.setBackgroundColor((Color.parseColor("#FF4500")));
        btnPC.setBackgroundColor((Color.parseColor("#FF4500")));
        btnTrms.setBackgroundColor((Color.parseColor("#FF4500")));
    }

    public void onSaveInstanceState (Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putInt(NBNAPO, nbNapo);
        outState.putInt(NBROY, nbRoy);
        outState.putInt(NB4F, nb4F);
        outState.putInt(NBMONT , nbMont);
        outState.putInt(NBRAC, nbRac);
        outState.putInt(NBHAW, nbHaw);
        outState.putInt(NBPC, nbPC);
        outState.putInt(NBTRMS, nbTrms);
    }
}
