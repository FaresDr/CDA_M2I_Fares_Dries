import { FlatList, StyleSheet, Text, Touchable, TouchableOpacity, View } from 'react-native'
import React from 'react'
import contactlist from '../data'

export default function ScreenListe({navigation}) {
    return (
        <View style={styles.container}>
            <FlatList data={contactlist} renderItem={(itemData) => {
                return (
                    <TouchableOpacity style={styles.contact} onPress={() => navigation.navigate("DetailContact" , {nom : itemData.item.nom, prenom : itemData.item.prenom, phone : itemData.item.phone_number, location : itemData.item.Location})}>
                        <View >
                            <Text style={styles.text}>{itemData.item.nom}   {itemData.item.prenom}</Text>
                        </View>
                    </TouchableOpacity>
                )
            }}
                keyExtractor={(item, index) => {
                    return index;
                }}

            >
            </FlatList>
        </View>
    )
}

const styles = StyleSheet.create({
    container :{
        flex:1,
        backgroundColor:"black",
    },

    contact:{               
        padding:15,
        marginVertical:20,
        marginHorizontal:20,
        backgroundColor:"red",
        justifyContent:'center',
        borderRadius:25,
        textAlign:'center',        
        alignItems:'center'
    },
    text:{
        fontSize:25,
        fontWeight:'bold',
        color : 'white'
    }
})

