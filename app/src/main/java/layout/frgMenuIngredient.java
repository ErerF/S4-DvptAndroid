package layout;


import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.appliworld.pizzeria.PizzeriaMainActivity;
import com.appliworld.pizzeria.R;

import static com.appliworld.pizzeria.R.id.btnAnchois;
import static com.appliworld.pizzeria.R.id.btnArtichauts;
import static com.appliworld.pizzeria.R.id.btnCapres;
import static com.appliworld.pizzeria.R.id.btnGorgonzola;
import static com.appliworld.pizzeria.R.id.btnJambonCru;
import static com.appliworld.pizzeria.R.id.btnJambonCuit;
import static com.appliworld.pizzeria.R.id.btnMozzarella;
import static com.appliworld.pizzeria.R.id.btnOlives;
import static com.appliworld.pizzeria.R.id.btnValider;

/**
 * A simple {@link Fragment} subclass.
 */
public class frgMenuIngredient extends Fragment implements View.OnClickListener{
    private Button btnMozza;
    private Button btnGorgon;
    private Button btnAnch;
    private Button btnCap;
    private Button btnOli;
    private Button btnArti;
    private Button btnJCru;
    private Button btnJCuit;
    private Button btnVal;

    public String pizza;

    private PizzeriaMainActivity context;

    public frgMenuIngredient() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_frg_menu_ingredient, container, false);

        //recuperer les boutons
        btnMozza = (Button) v.findViewById(btnMozzarella);
        btnGorgon = (Button) v.findViewById(btnGorgonzola);
        btnAnch = (Button) v.findViewById(btnAnchois);
        btnCap = (Button) v.findViewById(btnCapres);
        btnOli = (Button) v.findViewById(btnOlives);
        btnArti = (Button) v.findViewById(btnArtichauts);
        btnJCru = (Button) v.findViewById(btnJambonCru);
        btnJCuit = (Button) v.findViewById(btnJambonCuit);
        btnVal=(Button)v.findViewById(btnValider);

        //ajouter des ecouteurs aux boutons
        btnMozza.setOnClickListener(this);
        btnGorgon.setOnClickListener(this);
        btnAnch.setOnClickListener(this);
        btnCap.setOnClickListener(this);
        btnOli.setOnClickListener(this);
        btnArti.setOnClickListener(this);
        btnJCru.setOnClickListener(this);
        btnJCuit.setOnClickListener(this);
        btnVal.setOnClickListener(this);

        context= (PizzeriaMainActivity) this.getActivity();

        return v;
    }

    public void onClick(View v)
    {
        if(v.getId()==btnMozzarella)
        {   onClickMozza(); }
        else if(v.getId()==btnGorgonzola)
        {   onClickGorgon(); }
        else if(v.getId()==btnAnchois)
        {   onClickAnch(); }
        else if(v.getId()==btnCapres)
        {   onClickCap(); }
        else if(v.getId()==btnOlives)
        {   onClickOli(); }
        else if(v.getId()==btnArtichauts)
        {   onClickArti(); }
        else if(v.getId()==btnJambonCru)
        {   onClickJCru(); }
        else if(v.getId()==btnJambonCuit)
        {   onClickJCuit(); }
        else if(v.getId()==btnValider)
        {   onClickVal(); }
    }

    public void onClickMozza()
    {   context.order+="+mozzarella";
        btnMozza.setBackgroundColor((Color.parseColor("#FFFF00")));
    }
    public void onClickGorgon()
    {   context.order+="+gorgonzola";
        btnGorgon.setBackgroundColor((Color.parseColor("#FFFF00")));
    }
    public void onClickAnch()
    {   context.order+="+anchois";
        btnAnch.setBackgroundColor((Color.parseColor("#FFFF00")));
    }
    public void onClickCap()
    {   context.order+="+capres";
        btnCap.setBackgroundColor((Color.parseColor("#FFFF00")));
    }
    public void onClickOli()
    {   context.order+="+olives";
        btnOli.setBackgroundColor((Color.parseColor("#FFFF00")));
    }
    public void onClickArti()
    {   context.order+="+artichauts";
        btnArti.setBackgroundColor((Color.parseColor("#FFFF00")));
    }
    public void onClickJCru()
    {   context.order+="+jambon cru";
        btnJCru.setBackgroundColor((Color.parseColor("#FFFF00")));
    }
    public void onClickJCuit()
    {   context.order+="+jambon cuit";
        btnJCuit.setBackgroundColor((Color.parseColor("#FFFF00")));
    }
    public void onClickVal()
    {
        context.sendOrder();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frgMenu,((PizzeriaMainActivity)getActivity()).menuPizza);
        transaction.commit();
    }

    public void btnRouge()
    {
        btnMozza.setBackgroundColor((Color.parseColor("#FF4500")));
        btnGorgon.setBackgroundColor((Color.parseColor("#FF4500")));
        btnAnch.setBackgroundColor((Color.parseColor("#FF4500")));
        btnCap.setBackgroundColor((Color.parseColor("#FF4500")));
        btnOli.setBackgroundColor((Color.parseColor("#FF4500")));
        btnArti.setBackgroundColor((Color.parseColor("#FF4500")));
        btnJCru.setBackgroundColor((Color.parseColor("#FF4500")));
        btnJCuit.setBackgroundColor((Color.parseColor("#FF4500")));
    }
}
