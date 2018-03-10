using API_2048_FRAMEWORK_DAL.Manejadoras;
using API_2048_FRAMEWORK_ET;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace API_2048_FRAMEWORK_BL.Manejadoras
{
    public class ManejadoraUsuariosBL
    {
        ManejadoraUsuarios manejadoraDAL = new ManejadoraUsuarios();

        public clsUsuario getUsuarioPorId(String id)
        {
            clsUsuario usuario;

            usuario = manejadoraDAL.buscarUsuarioPorId(id);
            return usuario;
        }

        public int updateUsuario(clsUsuario usuario)
        {
            int resultado = 0;
            resultado = manejadoraDAL.updateUsuarioDAL(usuario);
            return resultado;
        }

        public int borrarUsuario(String id)
        {
            int resultado = 0;

            resultado = manejadoraDAL.deleteUsuario(id);

            return resultado;
        }

        public int addUsuario(clsUsuario usuario)
        {
            int resultado = 0;

            resultado = manejadoraDAL.addUsuarioDAL(usuario);

            return resultado;
        }
    }
}
