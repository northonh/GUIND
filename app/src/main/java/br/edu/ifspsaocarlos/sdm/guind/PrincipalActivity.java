package br.edu.ifspsaocarlos.sdm.guind;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class PrincipalActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView opcoesMenuLV;

    private DrawerLayout gavetaNavegacaoDL;

    private ActionBarDrawerToggle botaoABDT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        opcoesMenuLV = (ListView) findViewById(R.id.lv_opcoes_menu);
        opcoesMenuLV.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new String[]{"opcao 1", "opcao 2"}));
        opcoesMenuLV.setOnItemClickListener(this);

        gavetaNavegacaoDL = (DrawerLayout) findViewById(R.id.dl_gaveta_navegacao);
/*        gavetaNavegacaoDL.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                Toast.makeText(getApplicationContext(), "abriu", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                Toast.makeText(getApplicationContext(), "fechou", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });*/
        botaoABDT = new ActionBarDrawerToggle(this, gavetaNavegacaoDL, R.string.menu_aberto, R.string.menu_fechado){
            @Override
            public void onDrawerOpened(View drawerView) {
                Toast.makeText(getApplicationContext(), "abriu", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                Toast.makeText(getApplicationContext(), "fechou", Toast.LENGTH_SHORT).show();
            }
        };
        gavetaNavegacaoDL.addDrawerListener(botaoABDT);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String textoOpcao = ((TextView) view).getText().toString();
        getSupportActionBar().setSubtitle(textoOpcao);
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        botaoABDT.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        botaoABDT.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (botaoABDT.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
