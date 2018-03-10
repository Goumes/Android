using API_2048_FRAMEWORK_DAL.Manejadoras;
using API_2048_FRAMEWORK_ET;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace API_2048_FRAMEWORK_BL.Manejadoras
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
