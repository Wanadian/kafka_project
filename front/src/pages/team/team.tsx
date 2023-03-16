import './team.css'
import React from "react";

function Team() {
    return (
        <div className="team">
            <span className="card">
                <img className="photo" src="https://media.licdn.com/dms/image/C5603AQHm6ksb_eWIjw/profile-displayphoto-shrink_800_800/0/1656531822791?e=1684368000&v=beta&t=Kf1iM-dP3Obcu4XFebmMMnXiXRCsPj3jKreBmLi-No8"></img>
                <div>
                    <div className="name">Amandine Carlier</div>
                    <div className="email">Amandine.Carlier1@uphf.fr</div>
                </div>
            </span>
            <span className="card">
                <img className="photo" src="https://media.licdn.com/dms/image/C4D03AQGgHynXgc0Gdw/profile-displayphoto-shrink_800_800/0/1643484367193?e=1684368000&v=beta&t=1unbs-UAdI-Yfn0_uZRFJMg1Fq9Pnt5saga9Xi2q1bM"></img>
                <div>
                    <div className="name">William Denorme</div>
                    <div className="email">William.Denorme@uphf.fr</div>
                </div>
            </span>
            <span className="card">
                <img className="photo" src="https://media.licdn.com/dms/image/C4D03AQEh5jfBAIAZzg/profile-displayphoto-shrink_800_800/0/1574341764755?e=1684368000&v=beta&t=z-y1YLXiQrhH8FlIkNqhrstrrG-EIIkOEe2FvXu1UHg"></img>
                <div>
                    <div className="name">François Deroubaix</div>
                    <div className="email">Francois.Deroubaix@uphf.fr</div>
                </div>
            </span>
        </div>
    )
}

export default Team
