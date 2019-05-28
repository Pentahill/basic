package springbasic.propertyeditor;

import java.beans.PropertyEditorSupport;

public class TitlePositionEditor extends PropertyEditorSupport {
    private String[] options = { "Left", "Center", "Right" };

    @Override
    public String getAsText() {
        int value = (Integer)getValue();
        return options[value];
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        for(int i = 0; i < options.length; i++) {
            if(options[i].equals(text)) {
                setValue(i);
                return;
            }
        }
    }

    @Override
    public String[] getTags() {
        return options;
    }
}
