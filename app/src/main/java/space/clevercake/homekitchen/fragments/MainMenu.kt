package space.clevercake.homekitchen.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import space.clevercake.homekitchen.AddPlus
import space.clevercake.homekitchen.Cart
import space.clevercake.homekitchen.home.Home
import space.clevercake.homekitchen.MenuClickListener
import space.clevercake.homekitchen.Order
import space.clevercake.homekitchen.Profile
import space.clevercake.homekitchen.R

class MainMenu: Fragment(R.layout.fragment_main_menu) {
    private var listener: MenuClickListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MenuClickListener) {
            listener = context
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonHome: FrameLayout = view.findViewById(R.id.button_home)
        val buttonOrder: FrameLayout = view.findViewById(R.id.button_order)
        val buttonAddPlus: FrameLayout = view.findViewById(R.id.button_add_plus)
        val buttonCart: FrameLayout = view.findViewById(R.id.button_cart)
        val buttonUser: FrameLayout = view.findViewById(R.id.button_user)

        buttonHome.setOnClickListener {
            listener?.MenuСlick(Home())
        }

        buttonOrder.setOnClickListener {
            listener?.MenuСlick(Order())
        }

        buttonAddPlus.setOnClickListener {
            listener?.MenuСlick(AddPlus())
        }

        buttonCart.setOnClickListener {
            listener?.MenuСlick(Cart())
        }

        buttonUser.setOnClickListener {
            listener?.MenuСlick(Profile())
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}