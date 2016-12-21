    







//TODO Symbol
{
    const RED = Symbol();
    const ORANGE = Symbol("The color of a sunset!");
    RED === ORANGE  // false: every symbol is unique
};


    
//TODO Property names must be strings or symbols
{
    let obj = {};
    const SIZE = Symbol();
    obj[SIZE] = 8;
    obj[SIZE];      
    //obj[SIZE] and obj.SIZE (or obj["SIZE"]).
    console.log(obj[SIZE])
    console.log(obj.SIZE)
    console.log(obj["SIZE"])
};

/*
 * TODO s.rating = 3 执行的时候，3赋值给了一个临时的String对象，然后赋值结束后这个临时对象就消失了
 */
{
    const s = "hello";
    s.rating = 3;           // no error...success?
    s.rating;               // undefined
}

//TODO 类型转换
{
    const a = parseInt("16 volts", 10);  // the " volts" is ignored, 16 is
    // parsed in base 10
    const b = parseInt("3a", 16);        // parse hexadecimal 3a; result is 58
    const c = parseFloat("15.5 kph");    // the " kph" is ignored; parseFloat
    // always assumes base 10
}

//TODO date

{
    const d = new Date();         // current date
    const ts = d.valueOf();       // numeric value: milliseconds since
                                  // midnight, January 1, 1970 UTC    
}

//TODO to boolean
{
    const n = 0;              // "falsy" value
    const b1 = !!n;           // false
    const b2 = Boolean(n);    // false    
}


