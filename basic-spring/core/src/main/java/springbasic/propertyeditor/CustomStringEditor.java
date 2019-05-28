package springbasic.propertyeditor;

import java.beans.PropertyEditorSupport;

public class CustomStringEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue("hello editor");
    }
}
