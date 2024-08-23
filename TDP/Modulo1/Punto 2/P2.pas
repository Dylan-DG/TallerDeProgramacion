program P2;
const
    dimF = 300;
type
    datos = record
        codigo: integer;
        dni: integer;
        valorEX: real;
    end;
    oficinas = array[1..dimF] of datos;

procedure cargarVector(var v: oficinas; var dimL: integer);
begin
    Randomize;

    dimL:= 0;
    write('Ingrese el coodigo de la oficina: ');
    readln(v[dimL].codigo);
    while (dimL <= dimF)and(v[dimL].codigo<> -1) do 
    begin
        writeln('Ingrese el dni: ');
        v[dimL].dni:= random(99999);
        writeln('Ingrese el valor de la expensa: ');
        v[dimL].valorEX:= random(10000);
        dimL:= dimL + 1;
        write('Ingrese el coodigo de la oficina: ');
        readln(v[dimL].codigo);
    end;
end;

procedure ordenarIsertando(var v: oficinas; dimL: integer);
var
    i,j : integer;
    actual : integer;
begin
    for i := 2 to dimL do
    begin
        actual := v[i].codigo;
        j := i - 1;
        while (j > 0) and (v[j].codigo > actual) do
        begin
            v[j + 1].codigo := v[j].codigo;
            j := j - 1;
        end;
        v[j + 1].codigo := actual;
    end;
end;

procedure OrdenarSeleccion(var v: oficinas; dimL: integer);
var
    i, j, pos: integer;
    item: integer;
begin
    for i := 1 to dimL-1 do
    begin
        pos := i;

        for j := i+1 to dimL do
        begin
            if(v[j].codigo < v[pos].codigo) then
                pos:=j;
        end;
        
        item:=v[pos].codigo;
        v[pos].codigo := v[i].codigo;
        v[i].codigo:= item;
    end;
end;

var
    dimL: integer;
    v: oficinas;
begin
    cargarVector(v,dimL);
    OrdenarSeleccion(v,dimL);
end.
