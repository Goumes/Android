using _2048_API_CORE_DAL.Manejadoras;
using _2048_API_CORE_ET;
using System;
using System.Collections.Generic;
using System.Text;

namespace _2048_API_CORE_BL.Manejadoras
{
    public class ListadoUsuariosBL
    {
        public List<clsUsuario> getListadoUsuariosBL()
        {
            List<clsUsuario> lista;

            ListadoUsuarios listadoUsuariosDAL = new ListadoUsuarios();

            lista = listadoUsuariosDAL.getListadoUsuariosDAL();

            return lista;

        }
    }
}
