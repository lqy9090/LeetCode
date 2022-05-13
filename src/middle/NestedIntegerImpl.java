package middle;

import java.util.List;

public class NestedIntegerImpl implements NestedInteger{
    int value;
    List<NestedInteger> list;

    public NestedIntegerImpl(){};

    public NestedIntegerImpl(int value){};
    @Override
    public boolean isInteger() {
        return false;
    }

    @Override
    public Integer getInteger() {
        return value;
    }

    @Override
    public void setInteger(int value) {
        this.value = value;
    }

    @Override
    public void add(NestedInteger ni) {
        list.add(ni);
    }

    @Override
    public List<NestedInteger> getList() {
        return list;
    }
}
