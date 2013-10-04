/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 7/15/13
 * Time: 12:40 PM
 * To change this template use File | Settings | File Templates.
 */
Ext.define("HT.store.CurNamestore", {
    extend: 'Ext.data.Store',
    id: 'CurNamestore',
    autoLoad: false,
    fields: [
        'name'
        //{name: 'id', type: 'string'}
    ],

    listeners: {

        'beforeload': (function (ds) {
            var data="";
            if(Ext.ComponentQuery.query('Cour_inq')[0]!=undefined){
                data=Ext.encode({'autoContent': Ext.ComponentQuery.query('Cour_inq')[0].getValues().kcm});
            }
            else if(Ext.ComponentQuery.query('GridinqByCur_form')[0]!=undefined)  {
                data=Ext.encode({'autoContent': Ext.ComponentQuery.query('GridinqByCur_form')[0].getValues().kcm});

            }
            else if(Ext.ComponentQuery.query('inqstuname_form')[0]!=undefined)  {
                data=Ext.encode({'autoContent': Ext.ComponentQuery.query('inqstuname_form')[0].getValues().kcm});

            }
            else if(Ext.ComponentQuery.query('StuIds')[0]!=undefined)  {
                data=Ext.encode({'autoContent': Ext.ComponentQuery.query('StuIds')[0].down('form').getValues().kcm});

            }
            Ext.apply(
                ds.proxy.extraParams,
                {
                    'query':  data

                });


        })
    },
    proxy: {

        type: 'ajax',
        api: {
            read: '/Course/viewcurname.action'
        },
        //设定读取的格式
        reader: {
            type: 'json',
            //idProperty: 'id',
            root: 'data'



        }


    },


    remoteSort: true

});