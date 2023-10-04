import javax.swing.border.Border;
import java.awt.*;

public class RoundedBorder implements Border {
    private int roundedBorder;
    public RoundedBorder(int roundedBorder) {
        this.roundedBorder = roundedBorder;
    }

    public Insets getBorderInsets(Component c){
        return new Insets(this.roundedBorder+1, this.roundedBorder+1, this.roundedBorder+2, this.roundedBorder);
    }

    public boolean isBorderOpaque(){
        return true;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width-1, height-1, roundedBorder, roundedBorder);
    }
}
