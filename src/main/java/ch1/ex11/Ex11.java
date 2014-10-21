/**
 * @file
 * @par File Name:
 * Ex11.java
 * @author budougumi0617
 * @date Created on 2014/10/21
 */
package main.java.ch1.ex11;

/**
 * @author budougumi0617
 * @note void f()メソッドを持つ、IとJの２つのインターフェースがあり、両方を実装している
 *       クラスがあるとします。Iインターフェースのfメソッドが抽象、
 *       デフォルト、staticのどれかであり、Jインターフェースのfメソッドが抽象、デフォルト、staticの
 *       どれかである場合、全ての組み合わせで何が起きるでしょうか。同じように、
 *       スーパークラスSを拡張し、Iインターフェースを実装した場合に、インターフェースもvoid f()メソッドを
 *       持っていたら、どうなるか調べなさい。
 */
public class Ex11 {

    public class AbstructAndAbstruct implements AbstractI, AbstractJ {
        @Override
        public void f() {
            System.out
                    .println("Abstruct method f() and Abstruct method f() : Need Override");
        }
    }

    public class AbstructAndDefault implements AbstractI, DefaultJ {
        @Override
        public void f() {
            DefaultJ.super.f();
            System.out
                    .println("Abstruct method f() and Default method f() : Need Override");
        }
    }

    public class AbstructAndStatic implements AbstractI, StaticJ {
        @Override
        public void f() {
            StaticJ.f();
            System.out
                    .println("Abstruct method f() and Static method f() : Need Override");
        }

    }

    public class DefaultAndDefault implements DefaultI, DefaultJ {
        @Override
        public void f() {
            DefaultI.super.f();
            DefaultJ.super.f();
            System.out
                    .println("Default method f() and Default method f() : Need Override");
        }
    }

    public class DefaultAndStatic implements DefaultI, StaticJ {
        // Call f() from DefaultI Class
    }

    public class StaticAndStatic implements StaticI, StaticJ {
        public void f() {
            StaticI.f();
            StaticJ.f();
            System.out
                    .println("Static method f() and Static method f() : Cannot Use @Override");
        }
    }

    public class SuperAndAbstruct extends SuperClass implements AbstractI {
        @Override
        public void f() {
            // super.f();
            System.out
                    .println("SuperClass method f() and Abstruct method f() : Need Override");
        }
    }

    public class SuperAndDefault extends SuperClass implements DefaultI {
        @Override
        public void f() {
            super.f();
            DefaultI.super.f();
            System.out
                    .println("SuperClass method f() and Default method f() : Need Override");
        }
    }
    public class SuperAndStatic extends SuperClass implements StaticI {

    }

    void printResult() {
        new AbstructAndAbstruct().f();
        System.out.println("---");
        new AbstructAndDefault().f();
        System.out.println("---");
        new AbstructAndStatic().f();
        System.out.println("---");
        new DefaultAndStatic().f();
        System.out.println("---");
        new StaticAndStatic().f();
        System.out.println("---");
        new DefaultAndDefault().f();
        System.out.println("---");
        new SuperAndAbstruct().f();
        System.out.println("---");
        new SuperAndDefault().f();
        System.out.println("---");
        new SuperAndStatic().f();
    }

    /**
    * @param args
    */
    public static void main(String[] args) {
        Ex11 ex11 = new Ex11();
        ex11.printResult();
    }

}
