package sergiy.recyclerview

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView



/**
 * Created by sergiy on 16.03.18.
 */
open class RecyclerViewActivity : Activity() {
    private lateinit var rv: RecyclerView

    fun setAdapter(adapter: RecyclerView.Adapter<*>) {
        getRecyclerView().adapter = adapter
    }

    fun getAdapter(): RecyclerView.Adapter<*> {
        return getRecyclerView().adapter
    }

    fun setLayoutManager(mgr: RecyclerView.LayoutManager) {
        getRecyclerView().layoutManager = mgr
    }

    fun getRecyclerView(): RecyclerView {
        if (rv == null) {
            rv = RecyclerView(this)
            rv.setHasFixedSize(true)
            setContentView(rv)
        }
        return rv
    }
}