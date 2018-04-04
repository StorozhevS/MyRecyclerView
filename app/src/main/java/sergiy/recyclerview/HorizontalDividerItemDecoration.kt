package sergiy.recyclerview

/**
 * Created by sergiy on 20.03.18.
 */
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

// inspired by https://gist.github.com/polbins/e37206fbc444207c0e92

class HorizontalDividerItemDecoration(var divider : Drawable) : RecyclerView.ItemDecoration() {

    init {
        divider = divider.mutate()
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val left = parent.getPaddingLeft()
        val right = parent.getWidth() - parent.getPaddingRight()
        val childCount = parent.getChildCount()
        for (i in 0..childCount - 1) {

            val child = parent.getChildAt(i) as View
            val params = child.getLayoutParams() as RecyclerView.LayoutParams
            val top = child.getBottom() + params.bottomMargin;
            val bottom = top + divider.getIntrinsicHeight();
            divider.setBounds(left, top, right, bottom);
            divider.draw(c);
        }
    }
}