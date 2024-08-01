package space.clevercake.homekitchen.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import space.clevercake.homekitchen.home.Home
import space.clevercake.homekitchen.R

class MainContainer: Fragment(R.layout.fragment_main_container){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState == null) {
            childFragmentManager.beginTransaction()
                .replace(R.id.fragment_page, Home())
                .commit()
        }
    }

    fun replaceFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction()
            .replace(R.id.fragment_page, fragment)
            .commit()
    }
}