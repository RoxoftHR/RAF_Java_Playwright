package org.raf3k.guittesting.webtesting.types;

import org.openqa.selenium.By;
import org.raf3k.guittesting.UIReferences;
import org.raf3k.guittesting.webtesting.basetypes.WebControlBase;
import org.raf3k.shared.logging.Success;

import java.text.MessageFormat;

public class WbLabel extends WebControlBase {

    public WbLabel() {
    }

    public WbLabel(By searchBy, String alias) {
        super(searchBy, alias);
    }

    public WbLabel(By searchBy, WebControlBase parent, String alias) {
        super(searchBy, parent, alias);
    }


    /**
     * Verifies if the text of WebLabel is valid or not.
     *
     * @param sText   Expected text of a label.
     * @param bExists If true - check if text exist, if false - check if text does not exist.
     * @return Success object.
     */
    public Success verifyText(String sText, Boolean bExists) {
        return UIReferences.eval().evaluate(() ->
        {
            this.exists();

            if (bExists && !control().getText().equals(sText))
                throw new RuntimeException(MessageFormat.format("Label Text '{0}' is not as expected. Expected text: {1}.", control().getText(), sText));

            if (!bExists && control().getText().equals(sText))
                throw new RuntimeException(MessageFormat.format("Text is expected not to exist. Label Text: {0}, not expected text: {1}", control().getText(), sText));

        }, this, "");
    }

    /**
     * Verifies if the text of WebLabel contains given text or not.
     *
     * @param sText   Expected string that label text contains.
     * @param bExists If true - checks if text exist, if false - checks if text does not exist.
     * @return Success object.
     */
    public Success verifyTextContains(String sText, boolean bExists) {
        return UIReferences.eval().evaluate(() ->
        {
            this.exists();

            if (bExists && !control().getText().contains(sText))
                throw new RuntimeException(MessageFormat.format("Label Text \"{0}\" is not as expected. Expected text: {1}.", control().getText(), sText));

            if (!bExists && control().getText().contains(sText))
                throw new RuntimeException(MessageFormat.format("Text is expected not to exist. Label Text: {0}, not expected text: {1}", control().getText(), sText));
        }, this, "");
    }
}
