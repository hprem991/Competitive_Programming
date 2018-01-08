#pragma once

/********************************************************************************
Class Name	  :  Procedure Factory
Purpose		  :  Procedure Creator Factory
Author		  :  Prem Krishna Chettri, December 2017
Note		  :  This is a creator for template factory
*******************************************************************************/


#include "ProcedureBase.h"
#include "Brachy.h"
#include <map>


class ProcedureFactory
{
public:
    typedef ProcedureBase* (*ComponentFactoryFuncPtr)(); // This is the base class which holds the function
    typedef map<const char*, ComponentFactoryFuncPtr> map_type; // A map to hold the factory function pointer
    map_type m_Map;

public:
	ProcedureFactory(void);
	~ProcedureFactory(void);
   
	//We can't seperate impl of the following function to .cpp file 
    template<typename Type>
    short AddType(const char* componentName){
        ComponentFactoryFuncPtr function = &createType<Type>;
        m_Map.insert(std::make_pair(componentName, function));
		return 0;
    }

	template<typename Type>
	Type* getType(const char* componentName) {
		map_type::iterator mapIter;
		for(mapIter = m_Map.begin(); mapIter != m_Map.end(); mapIter++){
			if(strcmp(mapIter->first, componentName) == 0) {
				return ((Type *)(mapIter->second()));
			}
		}
		return NULL;
	}
};

//Prem, Templatized Factory Object Creation 
template<typename Type> 
ProcedureBase* createType() { 
    cout << "Creating Type \n";
    return new Type; 
}

