package com.example.recyclerview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;

import com.example.recyclerview.R;
import com.example.recyclerview.adaptador.RecyclerAdapter;
import com.example.recyclerview.model.ItemList;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.RecyclerItemClick, SearchView.OnQueryTextListener {
    private RecyclerView rvLista;
    private SearchView svSearch;
    private RecyclerAdapter adapter;
    private List<ItemList> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initValues();
        initListener();
    }



    private void initViews(){
        rvLista = findViewById(R.id.rvLista);
        svSearch = findViewById(R.id.svSearch);
    }

    private void initValues() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvLista.setLayoutManager(manager);

        items = getItems();
        adapter = new RecyclerAdapter(items, this);
        rvLista.setAdapter(adapter);
    }

    private void initListener() {
        svSearch.setOnQueryTextListener(this);
    }

    private List<ItemList> getItems() {
        List<ItemList> itemLists = new ArrayList<>();
        itemLists.add(new ItemList("PROGRAMACIÓN ANDROID", "El estudiante adquiere aprendizajes relacionados con las últimas tendencias en el desarrollo de aplicaciones móviles nativas, aprende a programar aplicaciones móviles basadas en el sistema operativo Android.", R.drawable.android));
        itemLists.add(new ItemList("INTERNET DE LAS COSAS", "Red de interconexión digital entre dispositivos, personas y la propia Internet que permite el intercambio de datos entre ellos.", R.drawable.iot));
        itemLists.add(new ItemList("PROYECTOS COLABORATIVOS", "Permite desarrollar habilidades y metodologías que promuevan la generación de iniciativas y soluciones innovadoras a situaciones problemáticas que tenga una empresa o institución real", R.drawable.proyectocolabora));
        itemLists.add(new ItemList("ARQUITECTURA DE SISTEMAS", "Permite aprender a diseñar la arquitectura de los sistemas informáticos para que estos cumplan los objetivos y necesidades que motivan su desarrollo.", R.drawable.arquitectura));
        itemLists.add(new ItemList("INGLÉS II BÁSICO", "Desarrollar las cuatro habilidades involucradas en la adquisición de una segunda lengua a nivel básico, mediante producción oral de diálogos, redacción de textos, lecturas y actividades de comprensión auditiva utilizando la gramática y vocabulario", R.drawable.ingles));
        itemLists.add(new ItemList("PREPARACIÓN LABORAL", "Permite a los alumnos poder aplicar lo aprendido en las aulas, interactuar con diversos grupos de interés y enfrentarse a un proyecto desafiante que los movilice desde la carrera.", R.drawable.empleo));
        itemLists.add(new ItemList("LENGUAJE", "Busca que los estudiantes pongan en práctica sus habilidades de comunicación, tanto orales como escritas, para intercambiar ideas, experiencias y opiniones con otras personas.", R.drawable.lenguaje));
        itemLists.add(new ItemList("PATRONES DE DISEÑO", "Entrega técnicas para resolver problemas comunes en el desarrollo de software y otros ámbitos referentes al diseño de interacción o interfaces. Un patrón de diseño resulta ser una solución a un problema de diseño.", R.drawable.patrones));
        itemLists.add(new ItemList("PROGRAMACIÓN.NET", "Esta asignatura entrega conocimientos de .NET, que es un Framework, un entorno de ejecución administrado para Windows que proporciona diversos servicios a las aplicaciones en ejecución..", R.drawable.net));
        itemLists.add(new ItemList("SISTEMAS OPERATIVOS", "Entrega a los alumnos el conocimiento de un conjunto de programas de un sistema informático que gestiona los recursos de hardware y provee servicios a los programas de aplicación de software.", R.drawable.sistoper));
        itemLists.add(new ItemList("PROGRAMACION WEB", " Permite la creación de sitios dinámicos en Internet. Esto se consigue generando los contenidos del sitio a través de una base de datos mediante lenguajes de programación Web.", R.drawable.web));
        itemLists.add(new ItemList("INGLES I", " Permite a los alumnos aprender temáticas básicas del idioma, es decir, aquellos capaces de comunicarse en situaciones cotidianas con expresiones de uso frecuente y vocabulario elemental..", R.drawable.ingles1));

        return itemLists;
    }

    @Override
    public void itemClick(ItemList item) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("itemDetail", item);
        startActivity(intent);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.filter(newText);
        return false;

        }


    }

