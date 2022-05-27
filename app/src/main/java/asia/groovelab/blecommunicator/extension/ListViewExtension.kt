package asia.groovelab.blecommunicator.extension

import android.widget.ExpandableListView
import android.widget.ListView
import androidx.databinding.BindingAdapter
import asia.groovelab.blecommunicator.adapter.ItemListAdapter
import asia.groovelab.blecommunicator.adapter.PeripheralListAdapter
import asia.groovelab.blecommunicator.model.Item
import asia.groovelab.blecommunicator.model.Peripheral
import asia.groovelab.blecommunicator.model.Section


@BindingAdapter("bind:peripherals")
fun ListView.setPeripherals(peripheralList: MutableList<Peripheral>?) {
    peripheralList?.let { list ->
        (adapter as? PeripheralListAdapter)?.run {
            peripherals = list
            notifyDataSetChanged()
        }
    }
}

@BindingAdapter("bind:sections")
fun ExpandableListView.setSections(sectionList: List<Section>?) {
    sectionList?.let { list ->
        (expandableListAdapter as? ItemListAdapter)?.run {
            sections = list
            notifyDataSetChanged()
        }
        expandGroupAll()
    }
}

@BindingAdapter("bind:items")
fun ExpandableListView.setItems(itemList: List<List<Item>>?) {
    itemList?.let { list ->
        (expandableListAdapter as? ItemListAdapter)?.run {
            items = list
            notifyDataSetChanged()
        }
        expandGroupAll()
    }
}

fun ExpandableListView.expandGroupAll() {
    IntRange(0, expandableListAdapter.groupCount - 1).forEach {
        if (!isGroupExpanded(it)) {
            expandGroup(it)
        }
    }
}