program
begin

    ** comment 
        in
        multiple
        lines 
    **

    x,y:integer;
    a:char;
    $a:char;
    b:boolean;
    c$:real;

    hex,oct:integer;
    
    float:real;

    x:=5;
    y:=7;

    a:='a';
    a:='@';
    b := x < y;
    
    hex:=0xab12c;
    oct:=00;
    
    float:=123.;
    float:=123.E3;
    float:=1.3E+21;
    float:=.1415926535;
    float:=.1415926535E-2;

    while b:
		while c$:
			begin
				a1,a2:integer;
				a1:=2;
			end	
		else
			begin
				a3,a4:integer;
				a3:=13;
			end
    else 
        c$:=1.5;
    b:=true and false or y<>x;
end .