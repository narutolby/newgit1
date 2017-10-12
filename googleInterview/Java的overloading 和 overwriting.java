package google.usefullquestion;overwriting 重写 dfs(String s) 重写一个一样的
Overloading 重载 dfs(String s,int l)


You are basically correct. Overloading is having multiple methods in a single class where the method has the same name. However, the return value is not seen as part of the signature of the method. Thus, you cannot overload a method by changing only the return value. You cannot have the following code, from your example:

public void setValue() {
   this.value = 0;
}

public int setValue() {
   return this.value;
}
This will fail to compile.

As Rob identified, I believe you mean overriding, and you have that correct. Note with overriding, you cannot change the return type. As of Java 5, you can return a derived type of what the base class method returned. Before Java 5, it must be the identical type. That is, you cannot do the below until Java 5 and later:

public class AnimalNoise {}
public class Miaw extends AnimalNoise {}

public class Animal {
    public AnimalNoise makeNoise() {
        return new AnimalNoise();
    }
}

public class Cat extends Animal {
    public Miaw makeNoise() {
        return new Miaw ();
    }
}
However, even in Java 5 and later, you cannot do the following:

public class Animal {
    public String makeNoise() {
        return "silence";
    }
}

public class Cat extends Animal {
    public Miaw makeNoise() {
        return new Miaw ();
    }
}
public class Miaw {}
Finally, a big difference between overloading and overriding that is often overlooked is that overloading is decided at compile time and overriding is decided at runtime. This catches many people by surprise when they expect overloading to be decided at runtime.
