using _2048_API_CORE_DAL.Conexion;
using _2048_API_CORE_ET;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Text;

namespace _2048_API_CORE_DAL.Manejadoras
{
    public class ListadoUsuarios
    {
        public List<clsUsuario> getListadoUsuariosDAL()
        {
            clsMyConnection miConexion;

            List<clsUsuario> listadoUsuarios = new List<clsUsuario>();

            SqlCommand miComando = new SqlCommand();

            SqlDataReader miLector;

            clsUsuario oUsuario;

            SqlConnection conexion;


            miConexion = new clsMyConnection();
            try
            {
                conexion = miConexion.getConnection();
                miComando.CommandText = "SELECT * FROM DB_users";

                miComando.Connection = conexion;
                miLector = miComando.ExecuteReader();

                //Si hay lineas en el lector
                if (miLector.HasRows)
                {
                    while (miLector.Read())
                    {
                        oUsuario = new clsUsuario();
                        oUsuario.id = (String)miLector["ID"];
                        oUsuario.highscore = Convert.ToInt32 (miLector["Highscore"]);
                        listadoUsuarios.Add(oUsuario);
                    }
                }

                miLector.Close();
                miConexion.closeConnection(ref conexion);
            }

            catch (SqlException exSql)
            {
                throw exSql;
            }

            return (listadoUsuarios);
        }
    }
}
