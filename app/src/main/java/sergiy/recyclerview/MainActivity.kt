package sergiy.recyclerview

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import android.widget.TextView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView


class MainActivity : RecyclerViewActivity() {

    private val items = arrayOf("lorem", "ipsum", "dolor", "sit", "amet", "consectetuer", "adipiscing", "elit", "morbi", "vel", "ligula", "vitae", "arcu", "aliquet", "mollis", "etiam", "vel", "erat", "placerat", "ante", "porttitor", "sodales", "pellentesque", "augue", "purus")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        setLayoutManager(LinearLayoutManager(this))
        setAdapter(IconicAdapter())
    }

    internal inner class IconicAdapter : RecyclerView.Adapter<RowHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
            return RowHolder(layoutInflater.inflate(R.layout.row, parent, false))
        }

        override fun onBindViewHolder(holder: RowHolder, position: Int) {
            holder.bindModel(items[position])
        }

        override fun getItemCount(): Int {
            return items.size
        }
    }

    internal class RowHolder(row: View) : RecyclerView.ViewHolder(row) {
        var label: TextView
        var size: TextView
        var icon: ImageView
        var template: String

        init {
            label = row.findViewById(R.id.label)
            size = row.findViewById(R.id.size)
            icon = row.findViewById(R.id.icon) as ImageView

            template = size.context.getString(R.string.size_template)
        }

        fun bindModel(item: String) {
            label.text = item
            size.text = String.format(template, item.length)

            if (item.length > 4) {
                icon.setImageResource(R.drawable.delete)
            } else {
                icon.setImageResource(R.drawable.ok)
            }
        }
    }
}
