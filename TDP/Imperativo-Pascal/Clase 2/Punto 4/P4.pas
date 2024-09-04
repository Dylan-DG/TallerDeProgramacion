program P4;

Procedure converBinario(dig:integer);
var
  resultado: integer;
begin
  resultado:=0;
  if(dig<>0) then 
  begin
    resultado := dig mod 2;
    writeln(dig div 2);
    converBinario(dig div 2);
  end;
  readln();
  write(resultado);
end; 

var
    num:integer;
begin
    write('ingrese el numero a convertir: ');
    readln(num);
    while(num<>0)do
    begin
        converBinario(num);
        writeln();
        write('ingrese el numero a convertir: ');
        readln(num);
    end;
end.
