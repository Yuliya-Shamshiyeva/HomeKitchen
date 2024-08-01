package space.clevercake.homekitchen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import space.clevercake.homekitchen.fragments.MainContainer
import space.clevercake.homekitchen.fragments.MainMenu

class MainActivity : AppCompatActivity() , MenuClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_main_container, MainContainer())
                .replace(R.id.fragment_main_menu, MainMenu())
                .commit()
        }
    }

    override fun MenuСlick(fragment: Fragment) {
        val mainContainer = supportFragmentManager.findFragmentById(R.id.fragment_main_container)
        if (mainContainer is MainContainer) {
            mainContainer.replaceFragment(fragment)
        }
    }
}