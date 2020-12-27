package com.example.pokedex

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.FragmentManager
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.pokedex.Common.Common
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val showType=object:BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if(intent!!.action!!.toString()==Common.KEY_POKEMON_TYPE)
            {
                val pokemonType = PokemonType.getInstance()
                val type = intent.getStringExtra("type")
                val bundle = Bundle()
                bundle.putString("type", type)
                pokemonType!!.arguments=bundle
                supportFragmentManager.popBackStack(0, FragmentManager.POP_BACK_STACK_INCLUSIVE)
                val fragmentTransaction=supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.list_pokemon_fragment, pokemonType)
                fragmentTransaction.addToBackStack("type")
                fragmentTransaction.commit()
                toolbar.title="POKEMON TYPE "+type.toUpperCase()
            }
        }

    }

    private val showDetail=object:BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if(intent!!.action!!.toString()==Common.KEY_ENABLE_HOME)
            {
                supportActionBar!!.setDisplayHomeAsUpEnabled(true)
                supportActionBar!!.setDisplayShowHomeEnabled(true)
                val detailFragment = PokemonDetail.getInstance()
                val position = intent.getIntExtra("position", -1)
                val bundle = Bundle()
                bundle.putInt("position", position)
                detailFragment.arguments=bundle
                val fragmentTransaction=supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.list_pokemon_fragment, detailFragment)
                fragmentTransaction.addToBackStack("detail")
                fragmentTransaction.commit()
                val pokemon=Common.pokemonList[position]
                toolbar.title=pokemon.name
            }
        }

    }
    private val showEvolution=object:BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if(intent!!.action!!.toString()==Common.KEY_NUM_EVOLUTION)
            {
                val detailFragment = PokemonDetail.getInstance()
                val num=intent.getStringExtra("num")
                val bundle = Bundle()
                bundle.putString("num", num)
                detailFragment.arguments=bundle
                val fragmentTransaction=supportFragmentManager.beginTransaction()
                fragmentTransaction.remove(detailFragment)
                fragmentTransaction.replace(R.id.list_pokemon_fragment, detailFragment)
                fragmentTransaction.addToBackStack("detail")
                fragmentTransaction.commit()
                val pokemon = Common.findPokemonByNum(num)
                toolbar.title=pokemon!!.name
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar.setTitle("Pokemon List")
        setSupportActionBar(toolbar)
        LocalBroadcastManager.getInstance(this)
            .registerReceiver(showDetail, IntentFilter(Common.KEY_ENABLE_HOME))
        LocalBroadcastManager.getInstance(this)
            .registerReceiver(showEvolution, IntentFilter(Common.KEY_NUM_EVOLUTION))
        LocalBroadcastManager.getInstance(this)
            .registerReceiver(showType, IntentFilter(Common.KEY_POKEMON_TYPE))
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item!!.itemId){
            android.R.id.home -> {
                toolbar.title="Pokemon List"
                supportFragmentManager.popBackStack("detail", FragmentManager.POP_BACK_STACK_INCLUSIVE)
                supportFragmentManager.popBackStack("type", FragmentManager.POP_BACK_STACK_INCLUSIVE)

                val pokemonList = PokemonList.getInstance()
                val fragmentTransaction = supportFragmentManager.beginTransaction()
                fragmentTransaction.remove(pokemonList!!)
                fragmentTransaction.replace(R.id.list_pokemon_fragment, pokemonList)
                fragmentTransaction.commit()

                supportActionBar!!.setDisplayShowHomeEnabled(false)
                supportActionBar!!.setDisplayHomeAsUpEnabled(false)
            }
        }
        return true
    }
}
