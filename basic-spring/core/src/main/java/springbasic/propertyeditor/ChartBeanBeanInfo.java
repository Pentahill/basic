package springbasic.propertyeditor;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

public class ChartBeanBeanInfo extends SimpleBeanInfo {

    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        PropertyDescriptor titlePositionDescriptor;
        try {
            titlePositionDescriptor = new PropertyDescriptor("titlePosition", ChartBean.class);
            titlePositionDescriptor.setPropertyEditorClass(TitlePositionEditor.class);
        } catch (IntrospectionException e) {
            return null;
        }

        return new PropertyDescriptor[]{titlePositionDescriptor};
    }
}
