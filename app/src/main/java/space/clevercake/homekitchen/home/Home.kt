package space.clevercake.homekitchen.home

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import space.clevercake.homekitchen.MenuClickListener
import space.clevercake.homekitchen.R

class Home : Fragment(R.layout.fragment_home) {
    private var switchListenerParam = true
    private lateinit var scrollHomeHorisontal: LinearLayout
    private lateinit var scrollHomeVertical: LinearLayout

    private lateinit var popularCookCard: View
    private lateinit var cookCard: View
    private lateinit var kitchenCard: View
    private lateinit var kitchenCard2: View

    private var listener: MenuClickListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MenuClickListener) {
            listener = context
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//Слушатель на кнопку выбора вверху
        val buttonCook: FrameLayout = view.findViewById(R.id.switch_on_cooks)
        val buttonKitchen: FrameLayout = view.findViewById(R.id.switch_on_kitchens)

        scrollHomeHorisontal = view.findViewById(R.id.scroll_popular_cooks)
        scrollHomeVertical = view.findViewById(R.id.scroll_all_cooks)


        popularCookCard = layoutInflater.inflate(
            R.layout.popular_cook_card,
            scrollHomeHorisontal,
            false
        )
        cookCard = layoutInflater.inflate(
            R.layout.cook_card,
            scrollHomeVertical,
            false
        )
        kitchenCard = layoutInflater.inflate(
            R.layout.home_dish_card,
            scrollHomeHorisontal,
            false
        )

        kitchenCard2 = layoutInflater.inflate(
            R.layout.home_dish_card,
            scrollHomeVertical,
            false
        )

        buttonCook.setOnClickListener {
            switchListenerParam = true
            switchListener(switchListenerParam)
            buttonCook.setBackgroundResource(R.drawable.style_button_switch_home_on)
            buttonKitchen.setBackgroundResource(R.drawable.style_button_switch_home)
        }
        buttonKitchen.setOnClickListener {
            switchListenerParam = false
            switchListener(switchListenerParam)
            buttonKitchen.setBackgroundResource(R.drawable.style_button_switch_home_on)
            buttonCook.setBackgroundResource(R.drawable.style_button_switch_home)
        }

        switchListener(switchListenerParam)
//Слушатель на кнопку выбора вверху
//Слушатель для обработки нажатия при выборе повора/блюда
        popularCookCard.setOnClickListener{
            listener?.MenuСlick(HomeCookProfile())
        }
        cookCard.setOnClickListener{
            listener?.MenuСlick(HomeCookProfile())
        }
        kitchenCard.setOnClickListener{
            listener?.MenuСlick(HomeDish())
        }
        kitchenCard2.setOnClickListener{
            listener?.MenuСlick(HomeDish())
        }
//Слушатель для обработки нажатия при выборе повора/блюда
    }

    private fun switchListener(switchListenerParam: Boolean) {
        scrollHomeHorisontal.removeAllViews()
        scrollHomeVertical.removeAllViews()

        if (switchListenerParam) {
                scrollHomeHorisontal.addView(popularCookCard)
                scrollHomeVertical.addView(cookCard)

        } else {
            scrollHomeHorisontal.addView(kitchenCard)
            scrollHomeVertical.addView(kitchenCard2)
        }
    }
}
