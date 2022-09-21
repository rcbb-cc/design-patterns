package cc.rcbb.design.patterns.composite.example1;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Composite 组合对象，通常需要存储子对象，定义有子部件的部件行为，并实现在Component里面定义的与子部件有关的操作
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/9/14
 */
public class Composite extends Component {
    /**
     * 用来存储组合对象中包含的子组件对象
     */
    private List<Component> childComponents = null;

    /**
     * 组合对象的名字
     */
    private String name = "";

    public Composite(String name) {
        this.name = name;
    }

    /**
     * 示意方法，通常在里面需要实现递归的调用
     */
    @Override
    public void someOperation() {
        if (childComponents != null) {
            for (Component c : childComponents) {
                //递归的进行子组件相应方法的调用
                c.someOperation();
            }
        }
    }

    /**
     * 输出组合对象自身的结构
     *
     * @param preStr 前缀，主要是按照层级拼接的空格，实现向后缩进
     */
    public void printStruct(String preStr) {
        //先把自己输出去
        System.out.println(preStr + " + " + this.name);
        //如果还包含有子组件，那么就输出这些子组件对象
        if (this.childComponents != null) {
            //然后添加一个空格，表示向后缩进一个空格
            preStr += " ";
            //输出当前对象的子对象了
            for (Component c : childComponents) {
                //递归输出每个子对象
                c.printStruct(preStr);
            }
        }
    }

    public void addChild(Component child) {
        // 延迟初始化
        if (childComponents == null) {
            childComponents = new ArrayList<Component>();
        }
        childComponents.add(child);
    }

    public void removeChild(Component child) {
        if (childComponents != null) {
            childComponents.remove(child);
        }
    }

    public Component getChildren(int index) {
        if (childComponents != null) {
            if (index >= 0 && index < childComponents.size()) {
                return childComponents.get(index);
            }
        }
        return null;
    }

}
