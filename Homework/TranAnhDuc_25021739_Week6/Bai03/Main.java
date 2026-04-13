interface Button {
    void render();
}

interface Checkbox {
    void render();
}


class WindowsButton implements Button {
    public void render() {
        System.out.println("Render Windows Button");
    }
}

class WindowsCheckbox implements Checkbox {
    public void render() {
        System.out.println("Render Windows Checkbox");
    }
}

class MacButton implements Button {
    public void render() {
        System.out.println("Render Mac Button");
    }
}

class MacCheckbox implements Checkbox {
    public void render() {
        System.out.println("Render Mac Checkbox");
    }
}


interface UIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

class WindowsFactory implements UIFactory {
    public Button createButton() {
        return new WindowsButton();
    }

    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

class MacFactory implements UIFactory {
    public Button createButton() {
        return new MacButton();
    }

    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

public class Main {
    public static void main(String[] args) {
        String config;         
        if (args.length > 0) {  
            config = args[0];   
        } else {               
            config = "win";   
        }   

        UIFactory factory;

        if (config.equalsIgnoreCase("mac")) {
            factory = new MacFactory();
        } else {
            factory = new WindowsFactory();
        }

        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        button.render();
        checkbox.render();
    }
}