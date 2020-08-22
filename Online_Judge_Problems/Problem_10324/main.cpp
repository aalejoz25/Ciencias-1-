#include <iostream>
using namespace std;

int main() {
	string cadena ="";
	int caso=1;
	
	while(cin>>cadena){
		
		int consultas;
		cin >> consultas;	
		cout<<"Case "<<caso++<<":"<<endl;
		for (int i=0;i<consultas;i++){
			
			int num1;
			int num2;
			cin >> num1 >> num2;
			int a;
			a = num1;
			int menor = min(num1,num2);
			int mayor = max(a,num2);
			int val_pos_menor = cadena[menor];
			bool iguales=true;
			for (int posicion = menor;posicion<=mayor;posicion++){
				if (val_pos_menor!=cadena[posicion]){
					iguales=false;
					break;					
				}		
			}
			if(iguales){
				cout<<"Yes"<< endl;
			}
			else{
				cout<<"No"<< endl;
			}					
		}		
	}
}

