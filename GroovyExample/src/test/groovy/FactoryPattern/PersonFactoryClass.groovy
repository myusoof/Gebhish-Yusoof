package FactoryPattern

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 18/04/14
 * Time: 22:16
 * To change this template use File | Settings | File Templates.
 */
class PersonFactoryClass {
    String gender

    public PersonFactoryClass(String gender){
        this.gender = gender
    }
    Person getInstance(){
        if(gender.equals("male")){
            return new Male()
        }else{
            return new Female()
        }
    }
}
