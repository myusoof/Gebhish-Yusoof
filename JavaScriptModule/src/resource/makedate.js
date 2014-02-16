var dat = new Date();
var month1 = new Array(12);
month1[0] = "1";
month1[1] = "2";
month1[2] = "3";
month1[3] = "4";
month1[4] = "5";
month1[5] = "6";
month1[6] = "7";
month1[7] = "8";
month1[8] = "9";
month1[9] = "10";
month1[10] = "11";
month1[11] = "12";
document.write(month1[dat.getMonth()] + "/" + dat.getDate()+ "/" + dat.getFullYear() );

