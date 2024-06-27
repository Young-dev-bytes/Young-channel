Now, the project is created for us. functional programming with java.
Let's get started with creating our first example.
The first problem that we would want to solve is, we would want to print a set of numbers.
So, we'll have a list of numbers, and we would want to actually print
each element in that list, one by one on a separate line.
Now, how do we do that in a traditional approach?
I've already create a new Java class. Functional01Structured, because I want to use structured approach, which is traditional approach to print a set of numbers.
ok, let's go ahead.
Let's add in a main method here, and over here I can write all the code that we would want.
We'd want to use a Structured approach, which is the traditional programming approach. Structured approach.
We'd want to print, a list of numbers.
How do we create a list of numbers?
I can say, List.of. Let's enter a sequence of numbers.
This can be random numbers.
The method does not really exist right?
Let's try and create the method right now.
The first thing that we'd need to think about is, how to loop the numbers?
That's the traditional approach, right? So, we would want to first figure out, how do you loop all the numbers.
And once you decide how to loop, you can take each of the individual numbers and print it.
Let's use the enhanced For loop. I'll say, for int number in numbers.
also you can use traditional for loop, that's the same thing.
We'd want to print them out. So, sysout, and number.
Let's run this and see what would happen.
You can see that everything is now printed out to the console.

That's the first thing that we did, when we were talking about the Structured approach.
Now, how do we solve the same thing in a functional approach?




========



Hi, are you still writing code like this?
In 2019?
Well, if you are, then you must watch this video.
Hi, my name is nelson.
And in this video I'm gonna show you exactly how to use java streams.
We all wrote code like this in the past and to be honest, nowadays, this is pretty much yeah, just just bad, really, because we are moving towards writing functional programming.
And when we write code like this, it means that we have to specify every single implementation or every single part or the the actual moving parts of the actual code,
And this can lead to a lot of errors, bugs and pretty much you know, no one does it anymore.
So in this video, I'm gonna show you exactly how to use java streams, which allows you to move away from imperative programming to declarative programming without whether to do.
Let's dive into it all right.
Let's go ahead and then about java streams.
If you're gonna grab the source code for this video, go ahead and check the link down below.
I've got a git hub repository with all the examples that I'm about to cover.
So basically I've got this project right here where I've got.
A class called person.
So if I just shift that for a second, so I've got this class called person that has name, age, and gender.
And then I also have this in them right here, which is the actual gender.
So male or female, and then I've got this class right here, which is the main class.
And this is where we're going to write every single piece of code.
So let's go ahead and learn.
First, what I mean by imperative approach.
So with imperative approach, you define every single step for what you're trying to.
So let's say that I have this list of people right here.
So let's say that we want to filter down every single female in this list right here.
So with imperative approach, what you would do is something like this.
So you would start with a list, and you would say this is of type person and then you'd say, females equals two. And then neo a realist. And then what you would do. You would do something like this.
So you'd say, four.
And then person.
And then person, and then this would be in people.
And then you would have an if condition.
So if and then person dot and then get gender dot equals to female, you would simply add it to your list, so females dot and then add,
and then person right.
So finally, let's go ahead and simply print this to the console.
So let's go ahead and loop again.
So simply go ahead and say females dot and then for each right here.
We can pass a consumer system, dot out and then column column print line.
Now, if I run this and.
You can see that we only have female in this list.
So this list right here, called female right, but you see that right here.
We are defining every single step of what we're trying to achieve.
So first we define a list and then we loop through the list.
And then we perform an if condition right here and then we print.
So what java streams allows us to do, and by the way, java streams works really, really well with collection.
So it's made for collections.
So what streams allows us to do is to simply ask what we want.
So instead of us defining, you know, this implementing show right here.
We can simply tell it what we want from our collection.
So to give an example.
So with the clarity of approach, we have a few methods within these stream API and basically we have filter sort all match any non match man makes group flat maps on and so forth.
But it's very moisture, exactly.
You know, these ones here and if you can learn more about java streams, go ahead and check out my course on java streams, which is absolutely free.
So what I'm going to do is the exact same thing right here.
But using java streams, which is using a declarative approach.
So we have film methods that I said, so filter, let's go ahead and start with filter.
So to use streams and filter what you have to do is simply say people.
So this is the initial collection that we want to start off and then simply say, dot and stream.
So when you say stream, this takes you to the abstraction and from now on, you simply ask what you want from the list.
List.
So right here we have a method called dot and then filter and filter takes a predicate and a predicate.
Simply returns true or false, and this is what you want to keep from the original list.
So in our case, this will take a person right.
And then we have to perform a condition.
So our condition was person dot and then get gender dot, and then equals to female, right.
So now that we perform the filter operation, now we have to collect the results back into a list and what this is doing is giving us a brand new list.
So to collect to a list, simply say dot, and then collect, and then say collectors, and then two, and then list.
Just like that.
So you can see that now I can extract this to a variable and what I want to say is females.
And in fact, let me go ahead and comment.
This code, and that there there we go.
So now I can grab this same line and then place it here and if I run the code.
You can see that we have the exact same thing, but right here you see that we're not, you know, creating a brand new list.
And then looping through that.
And then performing the if condition and then if that says, and then if that satisfies, then we add to the list, which you know, is too much code for something very simple.
So this is when declarative approach comes into play.
So we can do other things other than filter.
So if I go ahead and pretty much just comment online and we can also sort this list right here.
So the initial list right here saw people.
So let's say that we want to sort the list or actually first.
Let me go ahead and simply looped to people.
So if I and comment that, and then run this, you can see that we have both male and female, but the actual data is not sorted,
So you can see that fairs we have james bond h 2033, which is alina,57,1499, seven and and then the one,20.
But let's say that we want to sort this list by the actual h, so to do that, what we can do, we can simply say people dot n and stream.
So remember every time that you want to use the clarity of approach and enter the abstraction mode where you pretty much just ask what you want.
You simply have to say dot stream on a collection and then right here, simply say, dot, and then sort and thought takes a competitor.
So the competitor goes like this, simply say, competitor.
That comparing and then right here we can pass the actual field that we want to compare.
So in my case, I want to compare h, so i'm going to say, get, and then h, just like that.
Now I need to collect this to a list again.
So collect to list.
And then, if I extract this and simply say, sorted, and then pretty much just say, sorted right here and if I run this.
You can see that now our data is sorted by the actual h, so you can see seven,14,2033,57,99 and one.
20.
So if you want to reverse, so the actual order simply go ahead and say, dot and then reverse.
So if I run again, you can see that now it's reversed.
So one,2099.
57,33,2014, and then seven, and you could also change the comparative.
So you could say dot and then then comparing.
So let's say that we want to compare females. So females were actually gender. Not bad, and if I run this and right here you see that we first get female and then the next one is male,
but then we have two females. So 57.33 and then a male, and then the the last one, which is the the youngest person in this list, is a female.
So seven.
So this is awesome.
So we could also ask questions about our collection.
So this is when all match any match, and none match coming to play.
So let's say that we want to find out whether every single one in this list has an age bigger than five, right?
So to do that, we can say people dot and then stream.
And if you guess, and then all match.
This takes a predicate and right here we have to return a bullion for the condition that we are after.
So what we want is person dot and then get, and then age bigger than five, right?
So if I extract this to a variable or match and then salt, and then all match.
And if I run this, you can see now we get true.
So everybody in this list has an age bigger than five.
So if I was about to change this to, let's say, eight.
And then run this.
You can see that it's sauce because so anna cook, she's seven.
She's not bigger than eight and pretty much not everyone satisfies condition that I've just asked.
So you can also check any match, so any match pretty much just check for at least one.
So if I comment this, we could pretty pretty much just perform the same operation right here, based that, and this will be any match and then,
right here, instead of all match, simply say any match, and then pretty much we have at least one person which is bigger than a, I'll actually more people.
But basically it just finds one and then returns true.
If I run that you can see, that's true.
But if I say, do we have any match which is bigger than one?
21?
When this this will turn false because zelda, she's one,20 and we haven't got someone which has an age bigger than one.
21.
So also we could have the reverse non match.
So if I commend that out and then simply say, people thought, and then stream dot, and then non match.
And this takes a person.
So now we can ask a question.
So let's say that we want to find out if there isn't anyone with the name of.
Let's say antonio, so let's seem to say a person dot and then get, and then name dot, and then equals, and then antonio and an extract that were variable and then non match.
If I sought not much run this, you can see that it is true.
So there isn't anyone in this list with the name of antonio.
But let's go ahead and change.
James bond to antonio.
When this, you can see that this now returns false.
So as you see, the powerful of streams is just, you know, crazy.
So let me go ahead and show you max and mean.
So basically we can ask information about the max number or the max value within a collection.
So let's go ahead and find the person that has the maximum h so for that, people dot and then stream, and then dot max, and then inside,
It takes a competitor, so comparator, comparing, and you saw that before and then get h and then, if I extract this to a variable and this returns a an optional by the way,
and the reason why is because it might not, you know, find the max value within this collection, right?
So if I pretty much just say max and right here or actually just let me remove that.
So what I'm gonna do is that, and then right there.
Dot and any present.
And then person and simply salt, and then person.
And we can pretty much just replace this with method, reference, and there we go.
If I run this, you can see that zelda, she's the oldest person in this list, so let's do the same for men.
Someone to grab that, and then paste that in.
And when I'm gonna do is common.
That put a semi-column there and then, right here, instead of max, simply say, min.
When that, and now you can see that, and it cook.
She's the youngest person in our collection.
So this is awesome.
So we could also group information.
So this is where you want to group information based on a field that you have.
So let's say that we want to group this information based on gender, right?
So for that, we would expect a map with a gender, and then a list of each gender.
And then a list for the person within each gender.
So to do that, let's go ahead and simply say people don't enter stream and then dot, and then collect.
And now we not collect into a list because we want to map weight the genders and then each person within that gender.
So now we can use collectors dot and then grouping by so grouping by takes the actual field that we want to group by and what we want to group by is the actual gender.
So if I then extract this to a variable, you can see that now.
So group by and then gender.
So you can see that now this is a map of type, gender, and then a list of people.
So let's go ahead and loop through this group gender.
So group by gender, and then thought, and then for each, and this takes the gender.
And then people.
So right here, and you could rename this to people to something else.
But for now, let's go ahead and simply say, south.
And then gender.
And now what we're gonna do is simply say, people one.
Dot and then for rich, and then system dot out and in column column, print line.
So if I now run this, you can see that, and in fact, if I add us and then the south, there and then, when this,
You can see that right here. We have female, right.
So this is what we grouped and then everyone within female.
And then mail, and then everyone within mail.
So as you see, streams is just so so powerful and just imagine if we had to do all of this using imperative approach, right,
You'd have been like lots of lines of code and pretty much is just too much right.
So another thing that we can do is you see that I've just used a single method within string.
So what we can do is if I pretty much just comment this.
So the cool thing about streams is that we can chain these right.
So let me give you a quick example.
So let's say that we want to find out every single female and then grab the oldest female and then pretty much just return the first name.
So to do that, we would do something like this.
So you'd say people dot and then stream.
And now let's go ahead and say, simply filter.
So we want to filter females.
So person dot and then get, and then gender dot equals to female.
Then what we want to do, we want to find the oldest female.
So simply say, max.
And then comparator, comparing and then get, and then age.
Now we could also use the map.
So let's go ahead and say, map.
And now we want to grab the actual name and then end out with semi-column.
So now you can see that we have an optional, so this returns an optional, so oldest, and then female.
There we go.
Now I can say all this female h dot if present, and then name, and then system dot out dot printer len, and then name and basically I can use method reference right here as well.
So now, if I run this and now you can see that zelda brown is the oldest female in this list.
So this is just insane, right?
So as you can see, you can pretty much just change these and ask questions on your list instead of implementing every single step along the way.
All right.
So has he saw the benefits.
Using java streams, it's insane.
So the next step for you is to take out my course on java streams where I cover everything that we covered in this video, plus more.
Go ahead and roll to my course where I'm waiting for you.
Thanks for watching.
Don't forget to subscribe to get more videos like this and also make sure to follow me on my instagram where the community is growing.
This is often now join me in the next one.
See ya.
[音乐]
