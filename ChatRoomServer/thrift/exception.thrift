namespace java com.arkea.thrift.data.exception

/**
* Exception pour le service ChatRoom
**/

exception ServiceException {

            /** identifiant erreur */
           1:string id,

           /** message erreur */
           2:string message,
}