import { Button, StyleSheet, Text, View, Linking } from 'react-native'
import React, { useLayoutEffect } from 'react'



export default function ScreenDetail({ navigation, route }) {
    const nom = route.params.nom
    const prenom = route.params.prenom
    const phone = route.params.phone
    const location = route.params.location
    function handleCallPress() {
        Linking.openURL(`tel:${phone}`)
    }

    useLayoutEffect(() => {
        navigation.setOptions({ title: "Appeler ce contact" })
    }, [])
    return (
        <View style={styles.container}>
            <View style={styles.contact}>
                <Text style={styles.text}>{nom}</Text>
                <Text style={styles.text}>{prenom}</Text>
                <Text style={styles.text}>{phone}</Text>
                <Text style={styles.text}>{location}</Text>
            </View>
            <Button title='Appeler ce contact' onPress={() => handleCallPress()}></Button>
        </View>
    )
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: "black",
    },

    contact: {
        padding: 15,
        marginVertical: 20,
        marginHorizontal: 20,
        backgroundColor: "red",
        justifyContent: 'center',
        borderRadius: 25,
        textAlign: 'center',
        alignItems: 'center'
    },
    text: {
        fontSize: 25,
        fontWeight: 'bold',
        color: 'white'
    }
})
