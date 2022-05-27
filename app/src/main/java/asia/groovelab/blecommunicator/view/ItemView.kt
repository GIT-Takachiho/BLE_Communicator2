package asia.groovelab.blecommunicator.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods
import androidx.databinding.DataBindingUtil
import asia.groovelab.blecommunicator.R
import asia.groovelab.blecommunicator.databinding.ViewItemBinding
import asia.groovelab.blecommunicator.model.Item

@BindingMethods(BindingMethod(type = Item::class,
    attribute = "bind:item",
    method = "setItem"))
class ItemView : RelativeLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)

    private val binding: ViewItemBinding =
        DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.view_item,this, true)

    fun setItem(item: Item) {
        binding.item = item
    }
}