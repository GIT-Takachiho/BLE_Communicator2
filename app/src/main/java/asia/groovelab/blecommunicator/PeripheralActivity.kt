package asia.groovelab.blecommunicator

import android.os.Bundle
import android.widget.ScrollView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import asia.groovelab.blecommunicator.coroutine.LifecycleScope
import asia.groovelab.blecommunicator.coroutine.LifecycleScopeSupport
import asia.groovelab.blecommunicator.databinding.ActivityPeripheralBinding
import asia.groovelab.blecommunicator.extension.toast
import asia.groovelab.blecommunicator.viewmodel.PeripheralViewModel


class PeripheralActivity : AppCompatActivity(), LifecycleScopeSupport {
    override val scope = LifecycleScope(this)

    private val viewModel: PeripheralViewModel by lazy {
        val factory = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ViewModelProvider(this, factory).get(PeripheralViewModel::class.java)
    }
    private var scrollView: ScrollView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //  setup binding
        val binding: ActivityPeripheralBinding = DataBindingUtil.setContentView(this, R.layout.activity_peripheral)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        //  toolbar
        setSupportActionBar(binding.toolbar)

        //  initialize data
        if (savedInstanceState == null) {
            if (!viewModel.canAdvertise) {
                toast("can not start peripheral")
            }
        }
    }

    override fun onBackPressed() {
        viewModel.clear()
        super.onBackPressed()
    }
}